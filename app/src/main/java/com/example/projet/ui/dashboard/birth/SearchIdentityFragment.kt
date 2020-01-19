package com.example.projet.ui.dashboard.birth

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
import com.example.projet.ui.widgets.DateMask
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.search_identity_fragment.*
import javax.inject.Inject


class SearchIdentityFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, SearchIdentityViewModel::class) }
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.search_identity_fragment, container, false)
        return rootView
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        birth_date.addTextChangedListener(DateMask())

        btn_next.setOnClickListener {
            hideKeyboard()
            Navigation.findNavController(rootView).navigate(
                SearchIdentityFragmentDirections.actionSearchIdentityToResultIdentity(
                    firstName = first_name.text.toString(), lastName = last_name.text.toString(),
                    cin = cin.text.toString(), birthDate = birth_date.text.toString()
                )
            )
        }
        first_name.doAfterTextChanged { onTextChanged() }
        last_name.doAfterTextChanged { onTextChanged() }
        cin.doAfterTextChanged { onTextChanged() }
        birth_date.doAfterTextChanged { onTextChanged() }
        viewModel.isEnableLiveEvent
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                btn_next.isEnabled = it
            })

    }

    private fun onTextChanged() {
        viewModel.enableButtonForFirstStep(
            firstName = first_name.text.toString(),
            lastName = last_name.text.toString(),
            cin = cin.text.toString(),
            birthDate = birth_date.text.toString()
        )
    }

    companion object {
        fun newInstance() = SearchIdentityFragment()
    }
}
