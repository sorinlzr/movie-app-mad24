package com.example.movieappmad24.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage
import com.example.movieappmad24.utils.getSampleMoviesWithImages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Movie::class, MovieImage::class],
    version = 2,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun movieImageDao(): MovieImageDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val scope = CoroutineScope(Dispatchers.IO)
                            scope.launch {
                                val movieDao = getDatabase(context).movieDao()
                                val movieImageDao = getDatabase(context).movieImageDao()

                                val sampleMovies = getSampleMoviesWithImages()

                                for (sampleMovie in sampleMovies) {
                                    movieDao.add(sampleMovie.movie)

                                    for (image in sampleMovie.images) {
                                        movieImageDao.add(image)
                                    }
                                }
                            }
                        }
                    })
                    .build()
                    .also {
                        instance = it
                    }
            }
        }
    }
}