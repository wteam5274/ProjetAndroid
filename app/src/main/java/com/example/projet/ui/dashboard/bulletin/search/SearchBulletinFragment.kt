package com.example.projet.ui.dashboard.bulletin.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.projet.R
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.hideKeyboard
import com.example.projet.extensions.nonNull
import com.example.projet.extensions.vm
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.search_revenue_fragment.*
import javax.inject.Inject


class SearchBulletinFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, SearchBulletinViewModel::class) }
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.search_bulletin_fragment, container, false)
        return rootView
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_next.setOnClickListener {
            hideKeyboard()
            Navigation.findNavController(rootView).navigate(
                SearchBulletinFragmentDirections.actionSearchBulletinToBulletinList(cin.text.toString())
            )
        }
        cin.doAfterTextChanged { onTextChanged() }
        viewModel.isEnableLiveEvent
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                btn_next.isEnabled = it
            })

    }

    private fun onTextChanged() {
        viewModel.enableButton(
            cin = cin.text.toString()
        )
    }

    companion object {
        fun newInstance() = SearchBulletinFragment()
    }
}
