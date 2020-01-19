package com.example.projet.ui.dashboard.revenue

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projet.R
import com.example.projet.adapters.RevenueAdapter
import com.example.projet.data.models.Revenue
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.nonNull
import com.example.projet.extensions.vm
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_revenue_list.*
import kotlinx.android.synthetic.main.fragment_revenue_list.view.*
import timber.log.Timber
import javax.inject.Inject

const val DETAIL_REVENUE_FRAGMENT = "DETAIL_REVENUE_FRAGMENT"

class RevenueListFragment : Fragment() {

    /**
     * variables
     */
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, RevenueViewModel::class) }
    private lateinit var revenueAdapter: RevenueAdapter
    private lateinit var rootView: View
    private val safeArgs: RevenueListFragmentArgs by navArgs()


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_revenue_list, container, false)
        revenueAdapter = RevenueAdapter {
            Timber.d("revenueAdapter onClick $it")
            // navigate to fragment revenue details
            /*findNavController(rootView).navigate(
                RevenueListFragmentDirections.actionListRevenueToRevenueDetails(
                    fromFragmentName = DETAIL_REVENUE_FRAGMENT, idRevenue = it.id
                )
            )*/
        }
        rootView.recycler_view.layoutManager = LinearLayoutManager(activity!!.baseContext)
        rootView.recycler_view.adapter = revenueAdapter
        return rootView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRevenues(safeArgs.cin)
        // listener to liveData
        viewModel.revenuesMutableList
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                if (it.isNotEmpty()) handleViewState(it)
                else displayEmptyView()
            })
        viewModel.errorState
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                Snackbar.make(this.rootView, it!!.message.toString(), Snackbar.LENGTH_SHORT).show()
            })
        viewModel.showProgress.nonNull().observe(viewLifecycleOwner, Observer {
            if (it) progress_bar.visibility = View.VISIBLE else progress_bar.visibility = View.GONE
        })

    }

    /**
     * add revenues to adapater
     * and display in list
     */
    private fun handleViewState(list: List<Revenue>) {
        revenueAdapter.addRevenues(list)
    }

    /**
     * display empty view
     */
    private fun displayEmptyView() {
        tv_no_revenues.visibility = View.GONE
    }


}
