import { ActionTypes } from "../constants/actionTypes"

export const getCard = (products) => {
  return {
    type: ActionTypes.GET_CART,
    payload: products
  }
}

export const addCard = (cart) => {
  return {
    type: ActionTypes.ADD_CARD,
    payload: cart
  }
}

export const removeCart = (cart) => {
  return {
    type: ActionTypes.REMOVE_CARD,
    payload: cart
  }
}