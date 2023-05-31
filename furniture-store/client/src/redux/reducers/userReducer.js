import { ActionTypes } from "../constants/actionTypes";

const initialState = {
  user: {}
}

//initialState, action {type, payload }
export const userReducer = (state = initialState, { type, payload }) => {

  switch (type) {
    case ActionTypes.GET_USER:
    case ActionTypes.SIGN_UP_USER:
      return { ...state, user: payload };
    default:
      return state;
  }
}
