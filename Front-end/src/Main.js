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

function Main(){
    return(
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
    )
}

export default Main;