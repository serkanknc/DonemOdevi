package com.example.donemodevi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donemodevi.R
import com.example.donemodevi.adapter.UserAdapter
import com.example.donemodevi.ui.MainActivity
import com.example.donemodevi.ui.vm.MainViewModel
import com.example.donemodevi.utils.Resource


class ListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController
    private lateinit var userAdapter: UserAdapter
    private lateinit var rvUsers: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel

        rvUsers = view.findViewById(R.id.fr_list_rv_users)
        setupRecyclerView()

        navController = Navigation.findNavController(requireActivity(), R.id.ac_ma_nav_host_fragment)

        rvUsers = view.findViewById(R.id.fr_list_rv_users)

        viewModel.userRes.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    (requireActivity() as MainActivity).showLoading()
                }
                is Resource.Error -> {
                    (requireActivity() as MainActivity).hideLoading()
                    response.message?.let { message ->

                        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Success -> {
                    (requireActivity() as MainActivity).hideLoading()
                    response.data?.let { userResponse ->
                        if (userResponse != null) {
                                val userList = userResponse.toList()
                            userAdapter.differ.submitList(userList)
                        } else {
                            
                        }
                    }
                }
            }
            response.data = null
            response.message = null
        })

        userAdapter.setUserItemClickListener {
            val bundle = Bundle().apply {
                Log.i("DetailItem", it.toString())
                putSerializable("userItemDetail", it)
            }
            navController.navigate(
                    R.id.action_listFragment_to_detailFragment,
                    bundle
            )
        }
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter()
        rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(activity)
            viewModel.getUser()
        }
    }
}