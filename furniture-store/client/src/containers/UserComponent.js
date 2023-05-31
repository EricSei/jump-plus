import React, { useEffect } from "react";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
// import { getUser } from "../redux/actions/userActions";
import { getUser } from "../redux/actions/userActions";
import CartList from "./CartList";
import { getCard } from "../redux/actions/cartActions";
import MenuComponent from "./Menu";

const UserComponent = () => {

  //fetch user detail after singin 
  const user = useSelector(state => state.user)
  const { id, email } = user.user;
  console.log(id)
  const dispatch = useDispatch();
  // const cart = useSelector((state) => state.cart.cart)

  const fetchUserDetail = async (id) => {
    try {
      const response = await axios.get(`http://localhost:3004/users/${id}`)
      dispatch(getUser(response.data))
    } catch (error) {
      console.log(error)
    }
  }

  const fetchCart = async (userId) => {
    try {
      let response = await axios.get(`http://localhost:3004/carts?userId=${userId}`)
      console.log(response.data)
      let { id, productsOfCart } = response.data[0];



      //action , 
      // products pass in actions , return Object
      // Object is taken by Reducer : {type , payload}
      // then pass new state 

      dispatch(getCard(productsOfCart))



      /**
       * dispatch an action which carry new state /payload from the server and update the store
       */
      // return response.data;
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    // fetchUserDetail(id)
    // fetchCart(id)
  }, [id])

  return (
    <>
      <MenuComponent />
      {
        user && id &&
        < div className="ui grid container" >
          User Component
          id: {id} , email: {email}

          {/* <CartList userId={id} /> */}
        </div >
      }
    </>

  )
}

export default UserComponent;