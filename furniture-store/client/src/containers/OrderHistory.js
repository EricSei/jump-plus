import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom/cjs/react-router-dom.min';
import MenuComponent from './Menu';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { Icon, Table, List } from 'semantic-ui-react'

const OrderHistory = () => {

  let user = useSelector(state => state.user.user)
  let { id: userId } = user;
  console.log("user :", user)

  let [orders, setOrders] = useState([]);

  let dispatch = useDispatch();
  const fetchOrderHistory = async (userId) => {
    try {
      const response = await axios.get(`http://localhost:3004/orders?userId=${userId}`)
      console.log(response)
      let orderList = response.data;
      // dispatch(getOrders(orderList)) //somehow getOrders can not be exported
      setOrders(orderList)

    } catch (e) {
      console.error(e)
    }
  }

  useEffect(() => {
    fetchOrderHistory(userId)
  }, [])

  const renderProdcts = (products) => {

    return products.map(p => {
      let {
        id,
        title,
        price,
        description,
        category,
        quantity
      } = p;
      return (<List key={id}>
        <List.Item>
          Product Name : {title}
        </List.Item>
        <List.Item>
          Price: $ {price}
        </List.Item>
        <List.Item>
          Quantity {quantity}
        </List.Item>

      </List>)
    })
  }

  const renderOrders = (orders) => {
    return orders.map(order => {
      let { id, products, total } = order;
      return (
        <Table.Row>
          <Table.Cell> {id} </Table.Cell>
          <Table.Cell> {renderProdcts(products)} </Table.Cell>
          <Table.Cell negative> {total} </Table.Cell>
        </Table.Row>
      )
    })
  }
  // {orders[0]["userId"]}
  return (
    Array.isArray(orders) && orders.length > 0 && <>
      <MenuComponent />
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell> Order Number </Table.HeaderCell>
            <Table.HeaderCell> Products{ } </Table.HeaderCell>
            <Table.HeaderCell>Total </Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {renderOrders(orders)}
        </Table.Body>
      </Table>

    </>

  )
}

export default OrderHistory;