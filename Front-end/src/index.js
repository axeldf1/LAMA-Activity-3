// import react tools
import React from 'react';
import ReactDOM from 'react-dom';
// import the created Main component
import Main from './Main';
//add Semantic UI import
import 'semantic-ui-css/semantic.min.css'

import {createStore} from "redux";
import {Provider} from 'react-redux';
import globalReducer from "./reducers";
const store = createStore(globalReducer,window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());


//Insert a <Main> component inside the <div id='root'/>
// send the property title to the App component
ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <Main />
        </Provider>
    </React.StrictMode>,
    document.getElementById('root'));
