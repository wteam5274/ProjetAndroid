package com.example.projet.ui.dashboard.bulletin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projet.R
import com.example.projet.data.models.Bulletin
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.nonNull
import com.example.projet.extensions.vm
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_bulletin.*
import javax.inject.Inject

const val DETAIL_REVENUE_FRAGMENT = "DETAIL_REVENUE_FRAGMENT"

class BulletinListFragment : Fragment() {

    /**
     * variables
     */
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, BulletinViewModel::class) }
    private lateinit var rootView: View
    private val safeArgs: BulletinListFragmentArgs by navArgs()


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bulletin, container, false)

        return rootView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBulletin(safeArgs.cin)
        // listener to liveData
        viewModel.bulletinMutable
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                if (it != null) handleViewState(it)
                else displayEmptyView()
            })
        viewModel.errorState
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                Snackbar.make(this.rootView, it!!.message.toString(), Snackbar.LENGTH_SHORT).show()
            })

    }

    /**
     * add revenues to adapater
     * and display in list
     */
    private fun handleViewState(bulletin: Bulletin) {
        first_name.setText(bulletin.firstName)
        last_name.setText(bulletin.lastName)
        mather_name.setText(bulletin.matherName)
        addr.setText(bulletin.address)
        work.setText(bulletin.work)
        cin.setText(bulletin.cin)
        tribunal.setText(bulletin.tribunal)
        date_conviction.setText(bulletin.dateConviction)
        offense_nature.setText(bulletin.offenseNature)
        birth_date.setText(bulletin.birthDate)
    }

    /**
     * display empty view
     */
    private fun displayEmptyView() {
        Snackbar.make(this.rootView, rootView.resources.getString(R.string.no_result), Snackbar.LENGTH_SHORT).show()

    }

}
