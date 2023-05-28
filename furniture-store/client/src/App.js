import Header from "./containers/Header"

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import ProductDetail from "./containers/ProductDetail";
import ProductListing from "./containers/ProductListing";
import UserComponent from "./containers/UserComponent";

import "./App.css"

function App() {
  return (
    <div className="App">
      <Router >
        <Header />
        <Switch>
          {/* <Route path="/" exact component={ProductListing} /> */}
          {/* < Route path="/products/:productId" exact component={ProductDetail} /> */}
          < Route path="/user" exact component={UserComponent} />
          <Router > 404 Not Found </Router>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
