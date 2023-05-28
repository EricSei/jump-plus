import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import ProductCompnent from './ProductComponent';
import axios from 'axios';
import { setProducts } from '../redux/actions/productActions';
import UserComponent from './UserComponent';

const ProductListing = () => {

  const products = useSelector((state) => state) // ? 
  const dispatch = useDispatch();

  const fetchProducts = async () => {
    try {
      let response = await axios('https://fakestoreapi.com/products')
      console.log(response.data)

      //action , 
      // products pass in actions , return Object
      // Object is taken by Reducer : {type , payload}
      // then pass new state 
      dispatch(setProducts(response.data))

      /**
       * dispatch an action which carry new state /payload from the server and update the store
       */

    } catch (error) {
      console.log(error)
    }

  }

  useEffect(() => {
    fetchProducts()
  }, [])

  return (
    <div className='ui grid container'>
      <ProductCompnent />
      <UserComponent />
    </div>
  )
}

export default ProductListing;