import { ActionTypes } from "../constants/actionTypes"

export const getUser = (user) => {
  return {
    type: ActionTypes.GET_USER,
    payload: user
  }
}

export const signUpUser = (user) => {
  return {
    type: ActionTypes.SIGN_UP_USER,
    payload: user
  }
}

export const signInUser = (user) => {
  return {
    type: ActionTypes.SIGN_IN_USER,
    payload: user
  }
}

// export const setProducts = (products) => {
//   return {
//     type: ActionTypes.SET_PRODUCTS,
//     payload: products
//   }
// }

// export const selectedProduct = (product) => {

//   return {
//     type: ActionTypes.SELECTED_PRODUCT,
//     payload: product
//   }
// }

// export const removeSelectedProduct = () => {
//   return {
//     type: ActionTypes.REMOVE_SELECTED_PRODUCT
//   }
// }