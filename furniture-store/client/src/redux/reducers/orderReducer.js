import { ActionTypes } from "../constants/actionTypes"


const initialOrderState = {
  order: []
}

export const orderReducer = (state = initialOrderState, { type, payload }) => {
  console.log(type)
  console.log(payload)

  switch (type) {
    case ActionTypes.GET_ORDER: {
      return { ...state, order: payload }
    }
    case ActionTypes.ADD_ORDER:
      return { ...state, order: payload }
    default:
      return state;
  }
}