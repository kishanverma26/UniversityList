package com.example.universitieslist.di

import com.example.universitieslist.UniversityActivity
import com.example.universitieslist.ui.fragments.UniversityListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponents {
    fun inject(universityListFragment: UniversityListFragment)
}