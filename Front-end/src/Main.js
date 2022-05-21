import {
    BrowserRouter as Router,
    Routes,
    Route,
    Link
} from "react-router-dom";

import {Buy} from "./components/pages/buy";
import {Sell} from "./components/pages/sell";
import {Menu} from "./components/pages/menu";
import {Login} from "./components/pages/login";
import {Adduser} from "./components/pages/adduser";
import {Test} from "./components/pages/test";
import {createStore} from "redux";
import globalReducer from "./reducers";
import {Provider} from "react-redux";

const store = createStore(globalReducer, window.REDUX_DEVTOOLS_EXTENSION && window.REDUX_DEVTOOLS_EXTENSION());
function Main(){
    return(
        <Provider store={store}>
        <Router>
            <div>
                <Routes>
                    <Route exact path="/" element={<Login/>}/>
                    <Route exact path="/login" element={<Login/>}/>
                    <Route exact path="/buy" element={<Buy/>}/>
                    <Route exact path="/sell" element={<Sell/>}/>
                    <Route exact path="/menu" element={<Menu/>}/>
                    <Route exact path="/test" element={<Test/>}/>
                    <Route exact path="/adduser" element={<Adduser/>}/>
                </Routes>
            </div>
        </Router>
        </Provider>
    )
}

export default Main;