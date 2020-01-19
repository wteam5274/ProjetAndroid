package com.example.projet.ui.dashboard.birth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.projet.extensions.vm
import com.example.projet.R
import com.example.projet.data.models.Person
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.nonNull
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.result_identity_fragment.*
import timber.log.Timber
import javax.inject.Inject

class ResultIdentityFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, ResultIdentityViewModel::class) }
    private val safeArgs: ResultIdentityFragmentArgs by navArgs()
    private lateinit var rootView: View

    companion object {
        fun newInstance() = ResultIdentityFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.result_identity_fragment, container, false)
        return rootView
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("ResultIdentityFragment safeArgs firstName ${safeArgs.firstName} lastName ${safeArgs.lastName} cin ${safeArgs.cin} ${safeArgs.birthDate}")
        viewModel.getIdentity(safeArgs.cin, safeArgs.firstName, safeArgs.lastName, safeArgs.birthDate)
        viewModel.personsMutableList
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                displayPerson(person = it)
            })
        viewModel.errorState
            .nonNull()
            .observe(viewLifecycleOwner, Observer {
                Snackbar.make(rootView, it!!.message.toString(), Snackbar.LENGTH_SHORT).show()
            })

    }

    private fun displayPerson(person: Person) {
        first_name.setText(person.firstName)
        last_name.setText(person.lastName)
        birth_date.setText(person.birthDate)
        birth_place.setText(person.birthPlace)
        gender.setText(person.gender)
        father_name.setText(person.fatherName)
        nationality_father.setText(person.nationalityFather)
        mather_name.setText(person.matherName)
        nationality_mather.setText(person.nationalityMather)
        reporting_date.setText(person.reportingDate)
        reporting_name.setText(person.reportingName)
        state_registra_name.setText(person.stateRegistrarName)

    }

}
