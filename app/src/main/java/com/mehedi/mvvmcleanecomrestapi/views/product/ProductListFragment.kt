package com.mehedi.mvvmcleanecomrestapi.views.product

import androidx.fragment.app.viewModels
import com.mehedi.mvvmcleanecomrestapi.base.BaseFragment
import com.mehedi.mvvmcleanecomrestapi.data.model.product.ResponseProductItem
import com.mehedi.mvvmcleanecomrestapi.databinding.FragmentProductBinding
import com.mehedi.mvvmcleanecomrestapi.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate),
    ProductAdapter.Listener {
    
    private val viewmodel by viewModels<ProductViewmodel>()
    
    private val adapter: ProductAdapter by lazy {
        ProductAdapter(this)
    }
    
    override fun productClick(productId: Int) {
    
    
    }
    
    override fun setListener() {
        binding.productRcv.adapter = adapter
        
    }
    
    override fun allObserver() {
        
        viewmodel.productResponse.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {}
                is DataState.Loading -> {
                    loading.show()
                }
                
                is DataState.Success -> {
                    loading.dismiss()
                    setUiData(it.data)
                }
            }
            
            
        }
        
        
    }
    
    private fun setUiData(data: List<ResponseProductItem>?) {
        
        data?.let { products ->
            adapter.submitList(products)
            
        }
        
        
    }
    
    
}