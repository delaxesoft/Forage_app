package com.example.forageapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.forageapp.BaseApplication
import com.example.forageapp.R
import com.example.forageapp.databinding.FragmentForageableListBinding
import com.example.forageapp.ui.adapter.ForageableListAdapter
import com.example.forageapp.ui.viewmodel.ForageableViewModel
import com.example.forageapp.ui.viewmodel.ForageableViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER




class ForageableListFragment : Fragment() {

    // TODO: Refactor the creation of the view model to take an instance of
    //  ForageableViewModelFactory. The factory should take an instance of the Database retrieved
    //  from BaseApplication
    private val viewModel: ForageableViewModel by activityViewModels{
        ForageableViewModelFactory(
            (activity?.application as BaseApplication).database.forageableDao()
        )
    }

    private var _binding: FragmentForageableListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding=FragmentForageableListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    val adapter=ForageableListAdapter{forageable ->
    val action=ForageableListFragmentDirections
        .actionForageableListFragmentToForageableDetailFragment()
        findNavController().navigate(action)
    }
        // TODO: observe the list of forageables from the view model and submit it the adapter
       viewModel.forageables.observe(this.viewLifecycleOwner){forageable->
           forageable.let{
               adapter.submitList(it)
           }

       }
        binding.apply{
            recyclerView.adapter=adapter
            addForageableFab.setOnClickListener{
                findNavController().navigate(
                    R.id.action_forageableListFragment_to_addForageableFragment

                )
            }
        }
    }
}