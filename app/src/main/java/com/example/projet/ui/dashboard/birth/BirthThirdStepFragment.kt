package com.example.projet.ui.dashboard.birth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projet.R
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.vm
import javax.inject.Inject

class BirthThirdStepFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, SearchIdentityViewModel::class) }

    companion object {
        fun newInstance() = BirthThirdStepFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.birth_third_step_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
