import React, { Component } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Link, useHistory } from 'react-router-dom/cjs/react-router-dom.min';
import { Menu } from 'semantic-ui-react'
import { signOutUser } from '../redux/actions/userActions';

const MenuComponent = () => {

  let user = useSelector(state => state.user);
  let { id, email, name } = user.user
  const state = {}
  const history = useHistory()
  console.log(user)
  const { activeItem } = true;
  const dispatch = useDispatch();
  // handleItemClick = (e, { name }) => this.setState({ activeItem: name })
  const handleItemClick = () => {

  }

  const handleSignOut = (event) => {
    event.preventDefault();
    dispatch(signOutUser({ user: {} }))
    history.push('/')
  }

  return (
    user && id && email ? <>
      <Menu inverted>
        <Menu.Item
          name='editorials'
          active={activeItem === 'editorials'}
          onClick={handleItemClick}
        >
          <Link to={'/users/user'}> {name}  Profile </Link >
        </Menu.Item>

        <Menu.Item
          name='editorials'
          active={activeItem === 'editorials'}
          onClick={handleItemClick}
        >
          <Link to={'/products'}>   Search Products </Link >
        </Menu.Item>

        <Menu.Item
          name='reviews'
          active={activeItem === 'reviews'}
          onClick={handleItemClick}
        >
          <Link to={'/cart'}> Shopping Cart </Link >
        </Menu.Item>

        <Menu.Item
          name='upcomingEvents'
          active={activeItem === 'upcomingEvents'}
          onClick={handleItemClick}
        >
          <Link to={'/orders'}> View Order  </Link >
        </Menu.Item>
        <Menu.Item
          name='upcomingEvents'
          active={activeItem === 'upcomingEvents'}
          onClick={handleSignOut}
        >
          {/* <Link to={'/'}> Sign Out  </Link > */}
          Sign Out
        </Menu.Item>

        {/* Public Menu */}

      </Menu>
    </> : <>
      <Menu inverted>
        {/* Public Menu */}
        <Menu.Item
          name='upcomingEvents'
          active={activeItem === 'upcomingEvents'}
          onClick={handleItemClick}
        >
          <Link to={'/signin'}>Sign In</Link >
        </Menu.Item>
        <Menu.Item
          name='upcomingEvents'
          active={activeItem === 'upcomingEvents'}
          onClick={handleItemClick}
        >

          <Link to={'/signup'}>Register</Link >
        </Menu.Item>
      </Menu>

    </>

  )
}


export default MenuComponent;