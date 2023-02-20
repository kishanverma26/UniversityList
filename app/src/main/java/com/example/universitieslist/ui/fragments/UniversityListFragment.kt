package com.example.universitieslist.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universitieslist.AppApplication
import com.example.universitieslist.R
import com.example.universitieslist.databinding.UniversityListFragmentBinding
import com.example.universitieslist.models.UniversityRes
import com.example.universitieslist.ui.adapter.UniverSityAdapter
import com.example.universitieslist.utils.BaseFragment
import com.example.universitieslist.utils.OnAdapterClick
import com.example.universitieslist.viewmodels.UniversityViewModel
import com.example.universitieslist.viewmodels.UniversityViewModelFactory
import javax.inject.Inject

class UniversityListFragment : BaseFragment(R.layout.university_list_fragment) , OnAdapterClick {

    lateinit var universityListFragment: UniversityListFragmentBinding
    lateinit var viewModel: UniversityViewModel

    @Inject
    lateinit var viewModelFactory: UniversityViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        universityListFragment =
            UniversityListFragmentBinding.inflate(inflater, container, false)
        viewInitialize()
        initializeViewModel()

        return universityListFragment.root
    }

    private fun viewInitialize() {
        (requireActivity().application as AppApplication).appComponents.inject(this)

        universityListFragment.rvList.layoutManager = LinearLayoutManager(requireActivity())
        universityListFragment.ivBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(UniversityViewModel::class.java)

        arguments?.getString("query")?.let { viewModel.getList(it) }

        viewModel.universityList.observe(viewLifecycleOwner, Observer {
            if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
                if (it.size>0){
                universityListFragment.rvList.show()
                universityListFragment.tvEmptyView.hide()
                universityListFragment.progressCircular.hide()
                universityListFragment.rvList.adapter = UniverSityAdapter(it,this)
            }else{
                universityListFragment.rvList.hide()
                universityListFragment.tvEmptyView.show()
                universityListFragment.progressCircular.hide()
            }
            }
        })
    }

    override fun onItemClickListener(o: Any?, position: Int?) {
        var data = o as UniversityRes
        findNavController().navigate(
            R.id.list_to_webview,
            bundleOf("url" to data.webPages[0])
        )
    }
}


