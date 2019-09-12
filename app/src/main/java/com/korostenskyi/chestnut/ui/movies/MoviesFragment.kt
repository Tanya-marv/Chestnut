package com.korostenskyi.chestnut.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.korostenskyi.chestnut.R
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModel()
    private val adapter by lazy {
        MoviesAdapter(mutableListOf()) { }
    }

    private lateinit var sheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
        bindUi()
        viewModel.fetchMovieDiscover()
    }

    private fun bindUi() {
        viewModel.moviesLiveData.observe(this, Observer { movies ->
            adapter.addMovieList(movies)
        })
    }

    private fun setUpUi() {
        setUpBottomSheet()
        setUpButtons()
        setUpRecyclerView()
    }

    private fun setUpBottomSheet() {
        sheetBehavior = BottomSheetBehavior.from(clContentLayout).apply {
            isFitToContents = false
            isHideable = false
            state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun setUpButtons() {
        filterIcon.setOnClickListener { toggleFilters() }
    }

    private fun setUpRecyclerView() {
        rvMovies.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@MoviesFragment.adapter
        }
    }

    private fun toggleFilters() {
        if (sheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) sheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED)
        else sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
    }
}
