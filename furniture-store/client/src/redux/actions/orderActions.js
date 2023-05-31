import { ActionTypes } from "../constants/actionTypes"

export const gerOrders = (orderList) => {
  return {
    type: ActionTypes.GET_ORDER,
    payload: orderList
  }
}