import { combineReducers } from 'redux';
import { productReducer, selectedProductReducer } from './productReducer';
import { cartReducer } from './cartReducer'
import { userReducer } from './userReducer';


const reducers = combineReducers({
  allProducts: productReducer,
  product: selectedProductReducer,
  user: userReducer,
  cart: cartReducer
})

export default reducers;
