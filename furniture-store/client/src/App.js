import Header from "./containers/Header"

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import ProductDetail from "./containers/ProductDetail";
import ProductListing from "./containers/ProductListing";
import UserComponent from "./containers/UserComponent";
import OrderHistory from "./containers/OrderHistory";


import "./App.css"
import SignUpComponent from "./containers/SignUpComponent";
import SignInComponent from "./containers/SignInComponent";
import Home from "./containers/Home";
import CartList from "./containers/CartList";
import 'semantic-ui-css/semantic.min.css'

function App() {
  return (
    <div className="App">
      <Router >
        {/* <Header /> */}
        <Switch>
          <Route path="/" exact component={Home} />
          < Route path="/products/:productId" exact component={ProductDetail} />

          <Route path="/products" exact component={ProductListing} />

          <Route path="/signup" exact component={SignUpComponent} />
          <Route path="/signin" exact component={SignInComponent} />

          {/* private route */}
          < Route path="/users/user" exact component={UserComponent} />
          <Route path="/cart" exact component={CartList} />
          <Route path="/orders" exact component={OrderHistory} />
          <Router > 404 Not Found </Router>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
