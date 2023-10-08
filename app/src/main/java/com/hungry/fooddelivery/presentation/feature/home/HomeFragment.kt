package com.hungry.fooddelivery.presentation.feature.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hungry.fooddelivery.data.dummy.DummyCategoryDataSource
import com.hungry.fooddelivery.data.dummy.DummyCategoryDataSourceImpl
import com.hungry.fooddelivery.data.local.database.AppDatabase
import com.hungry.fooddelivery.data.local.database.datasource.MenuDatabaseDataSource
import com.hungry.fooddelivery.data.repository.MenuRepository
import com.hungry.fooddelivery.data.repository.MenuRepositoryImpl
import com.hungry.fooddelivery.databinding.FragmentHomeBinding
import com.hungry.fooddelivery.databinding.ItemSectionMenuBinding
import com.hungry.fooddelivery.model.Menu
import com.hungry.fooddelivery.presentation.feature.detail.DetailActivity
import com.hungry.fooddelivery.presentation.feature.home.adapter.HomeAdapter
import com.hungry.fooddelivery.utils.GenericViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var bindLayoutPref: ItemSectionMenuBinding

    private val adapter: HomeAdapter by lazy {
        HomeAdapter {
            navigateToDetail(it)
        }
    }

    private fun navigateToDetail(item: Menu) {
        DetailActivity.startActivity(requireContext(),item)
    }

    private val viewModel: HomeViewModel by viewModels {
        val cds: DummyCategoryDataSource = DummyCategoryDataSourceImpl()
        val database = AppDatabase.getInstance(requireContext())
        val menuDao = database.MenuDao()
        val menuDataSource = MenuDatabaseDataSource(menuDao)
        val repo: MenuRepository = MenuRepositoryImpl(menuDataSource, cds)
        GenericViewModelFactory.create(HomeViewModel(repo))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        fetchData()
    }

    private fun fetchData() {
        viewModel.homeData.observe(viewLifecycleOwner){
            adapter.submitData(it)
        }
    }

    private fun setupList() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@HomeFragment.adapter
        }
    }

}
