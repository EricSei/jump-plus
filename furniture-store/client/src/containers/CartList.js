import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';
import { getCard } from '../redux/actions/cartActions';
import { Link } from 'react-router-dom/cjs/react-router-dom.min';
import { Grid, Image, Card, Button } from 'semantic-ui-react'
import MenuComponent from './Menu';

const CartList = (props) => {

  const cart = useSelector((state) => state.cart.cart) // ? 
  const user = useSelector(state => state.user.user)
  console.log(cart)

  let { id, userId, productsOfCart } = cart;
  const dispatch = useDispatch();
  console.log(productsOfCart)
  let totalCost = 0;
  const fetchCart = async (userId) => {
    try {
      let response = await axios.get(`http://localhost:3004/carts?userId=${userId}`)
      console.log(response.data)
      let { id, productsOfCart } = response.data[0];
      //action , 
      // products pass in actions , return Object
      // Object is taken by Reducer : {type , payload}
      // then pass new state 

      dispatch(getCard(response.data[0]))
      /**
       * dispatch an action which carry new state /payload from the server and update the store
       */
      // return response.data;
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    fetchCart(user.id)
    totalCost = getTotalCost(productsOfCart)
  }, [totalCost])

  const getTotalCost = (products) => {
    let decimalCost = products.reduce((acc, x) => { return acc + (x.price * x.quantity) }, 0);
    let cost = Math.round(decimalCost * 100) / 100;
    return cost;
  }

  const getDiscount = (cost) => {
    let decimalCost = cost > 2000 ? cost * 0.9 : cost;
    let formattedCost = Math.round(decimalCost * 100) / 100
    return formattedCost;
  }

  const renderList = (products) => {
    return products.map(product => {
      const { id, title, image, price, category, quantity } = product;
      const cost = price * quantity;
      return (
        <Grid.Column key={id}>
          <Card>
            <Card.Content>
              <Card.Header>
                Title: {title}
              </Card.Header>
              <Card.Meta>
                Category: {category}
              </Card.Meta>
              <Card.Header>
                Price:  {price}
              </Card.Header>
              <Card.Header>
                Quantity : {quantity}
              </Card.Header>
              <Card.Header>
                Cost $ : {cost}
              </Card.Header>

              {/* <Image src={image} /> */}
            </Card.Content>
          </Card>
        </Grid.Column>
      )
    })
  }

  return (
    <>
      <MenuComponent />
      {
        Array.isArray(productsOfCart) && productsOfCart.length > 0 ?
          <>
            <Card.Group centered>
              <Card color='red'>

                <Card.Content>
                  <Card.Header color='blue' > Total Cost : {getTotalCost(productsOfCart)}</Card.Header>
                  {
                    getTotalCost(productsOfCart) > 2000 ?
                      <Card.Header> After Disconted Cost : {getDiscount(getTotalCost(productsOfCart))} </Card.Header>
                      : <Card.Header> Spend $ 2000 and get 10 % discount ! </Card.Header>
                  }
                </Card.Content>
                <Button size="big"> Place Order </Button>
              </Card>
            </Card.Group>

            <div className='ui grid container'>
              <Grid divided>
                <Grid.Row columns={3} divided>
                  <> {renderList(productsOfCart)}</>
                </Grid.Row>
              </Grid>
            </div>
          </>
          :
          <div className='ui grid container'>
            <div className='header'>
              Shopping Cart is empty.
            </div>
          </div>
      }
    </>
  )
}

export default CartList;