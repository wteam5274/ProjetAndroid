package com.example.projet.ui.dashboard.revenue.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projet.R
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.nonNull
import com.example.projet.extensions.vm
import com.example.projet.ui.dashboard.revenue.RevenueViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject


class DetailRevenueFragment : Fragment() {
    private val safeArgs: DetailRevenueFragmentArgs by navArgs()
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, DetailRevenueViewModel::class) }
    private lateinit var rootView: View


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_detail_revenue, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("DetailRevenueFragment safeArgs ${safeArgs.idRevenue}")
        viewModel.getRevenues(safeArgs.idRevenue)
        viewModel.revenueMutable
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                Timber.d("getRevenue  $it")

            })
        viewModel.errorState
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                Snackbar.make(this.rootView, it!!.message.toString(), Snackbar.LENGTH_SHORT).show()
            })
    }


}
