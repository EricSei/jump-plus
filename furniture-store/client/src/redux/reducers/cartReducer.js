import { ActionTypes } from "../constants/actionTypes"


const initialCartState = {
  cart: {}
}

export const cartReducer = (state = initialCartState, { type, payload }) => {
  console.log(type)
  console.log(payload)

  switch (type) {
    case ActionTypes.GET_CART: {
      return { ...state, cart: payload }
    }
    // case ActionTypes.REMOVE_CART: // remove a prod from cart
    //   return { ...state, ...payload }
    default:
      return state;
  }
}