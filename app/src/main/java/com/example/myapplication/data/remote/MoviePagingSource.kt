package com.example.myapplication.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplication.MovieRepository
import com.example.myapplication.data.entities.local.ResultModel

class MoviePagingSource(
    private val repo: MovieRepository,
) : PagingSource<Int, ResultModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultModel> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPage = params.key ?: 1
            val response = repo.getTop(nextPage)
            val movies = response.results
            LoadResult.Page(
                data = movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? = null
}