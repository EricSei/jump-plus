import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import ProductComponent from './ProductComponent';
import axios from 'axios';
import { setProducts } from '../redux/actions/productActions';
import MenuComponent from './Menu';
import { Grid, Image } from 'semantic-ui-react'



const ProductListing = () => {

  const products = useSelector((state) => state) // ? 
  const dispatch = useDispatch();

  const fetchProducts = async () => {
    try {
      let response = await axios('http://localhost:3004/products')
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
    <>
      <MenuComponent />
      <Grid columns={3}>
        <Grid.Row  >
          <ProductComponent />
        </Grid.Row>
      </Grid>
    </>

  )
}

export default ProductListing;