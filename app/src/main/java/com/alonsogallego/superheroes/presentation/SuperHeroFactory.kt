package com.alonsogallego.superheroes.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.alonsogallego.app.data.db.AppDatabase
import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.ApiClient
import com.alonsogallego.superheroes.data.appearance.AppearanceDataRepository
import com.alonsogallego.superheroes.data.appearance.local.mem.AppearanceMemLocalDataSource
import com.alonsogallego.superheroes.data.appearance.remote.api.AppearanceApiRemoteDataSource
import com.alonsogallego.superheroes.data.biography.BiographyDataRepository
import com.alonsogallego.superheroes.data.biography.local.mem.BiographyMemLocalDataSource
import com.alonsogallego.superheroes.data.biography.remote.api.BiographyApiRemoteDataSource
import com.alonsogallego.superheroes.data.connections.ConnectionsDataRepository
import com.alonsogallego.superheroes.data.connections.local.db.ConnectionsDbLocalDataSource
import com.alonsogallego.superheroes.data.connections.remote.api.ConnectionsApiRemoteDataSource
import com.alonsogallego.superheroes.data.powerstats.PowerStatsDataRepository
import com.alonsogallego.superheroes.data.powerstats.local.xml.PowerStatsXmlLocalDataSource
import com.alonsogallego.superheroes.data.superheroe.SuperHeroDataRepository
import com.alonsogallego.superheroes.data.superheroe.local.db.SuperHeroDbLocalDataSource
import com.alonsogallego.superheroes.data.superheroe.remote.api.SuperHeroApiRemoteDataSource
import com.alonsogallego.superheroes.data.work.WorkDataRepository
import com.alonsogallego.superheroes.data.work.local.mem.WorkMemLocalDataSource
import com.alonsogallego.superheroes.data.work.remote.api.WorkApiRemoteDataSource
import com.alonsogallego.superheroes.domain.*
import com.iesam.superhero.data.powerstats.remote.api.PowerStatsApiRemoteDataSource

class SuperHeroFactory {

    fun getSuperHerosViewModel(applicationContext: Context) =
        SuperHerosViewModel(getSuperHeroUseCase(applicationContext))

    fun getSuperHeroDetailViewModel(
        applicationContext: Context
    ): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(
            getSuperHeroDetailUseCase(applicationContext)
        )
    }

    private fun getSuperHeroUseCase(context: Context): GetSuperHeroFeedUseCase {
        return GetSuperHeroFeedUseCase(
            getSuperHeroRepository(context),
            getBiographyRepository(),
            getWorkRepository(),
        )
    }

    private fun getSuperHeroDetailUseCase(
        applicationContext: Context
    ): GetSuperHeroDetailUseCase {
        return GetSuperHeroDetailUseCase(
            getSuperHeroRepository(applicationContext),
            getBiographyRepository(),
            getWorkRepository(),
            getConnectionsRepository(applicationContext),
            getPowerStatsRepository(getSharedPreferences(applicationContext, "power_stats")),
            getAppearanceRepository()
        )
    }

    private fun getBiographyRepository(): BiographyRepository {
        return BiographyDataRepository(
            BiographyMemLocalDataSource(DataStoreSingletonPlus.getInstance()),
            BiographyApiRemoteDataSource(getApiClient())
        )
    }

    private fun getConnectionsRepository(applicationContext: Context): ConnectionsRepository {
        return ConnectionsDataRepository(
            ConnectionsDbLocalDataSource(
                DataBaseSingleton.getInstance(applicationContext).connectionsDao()
            ),
            ConnectionsApiRemoteDataSource(getApiClient())
        )
    }

    private fun getPowerStatsRepository(sharedPreferences: SharedPreferences): PowerStatsRepository {
        return PowerStatsDataRepository(
            PowerStatsXmlLocalDataSource(sharedPreferences),
            PowerStatsApiRemoteDataSource(getApiClient())
        )
    }

    fun getSuperHeroRepository(context: Context): SuperHeroRepository {
        return SuperHeroDataRepository(
            SuperHeroDbLocalDataSource(DataBaseSingleton.getInstance(context).superHeroDao()),
            SuperHeroApiRemoteDataSource(getApiClient())
        )
    }

    fun getWorkRepository(): WorkRepository {
        return WorkDataRepository(
            WorkMemLocalDataSource(),
            WorkApiRemoteDataSource(getApiClient())
        )
    }

    fun getAppearanceRepository(): AppearanceRepository {
        return AppearanceDataRepository(
            AppearanceMemLocalDataSource(),
            AppearanceApiRemoteDataSource()
        )
    }

    private fun getApiClient() = ApiClient()

    private fun getSharedPreferences(
        context: Context,
        nameSharedPreferences: String
    ): SharedPreferences {
        return context.getSharedPreferences(nameSharedPreferences, Context.MODE_PRIVATE)
    }

    object DataBaseSingleton {
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "db-superhero"
                ).build()
            }
            return db!!
        }

    }

    object DataStoreSingleton {
        private val dataStore: MutableMap<Int, SuperHero> = mutableMapOf()

        fun put(id: Int, biography: SuperHero) {
            dataStore.put(id, biography)
        }

        fun get(id: Int) = dataStore[id]
    }

    object DataStoreSingletonPlus {
        private var dataStore: MemDataStore<Biography>? = null

        fun getInstance(): MemDataStore<Biography> {
            if (dataStore == null) {
                dataStore = MemDataStore()
            }
            return dataStore!!
        }
    }
}