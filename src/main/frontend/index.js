import React from "react";
import {render} from "react-dom";
import {Provider} from "react-redux";
import App from "./containers/App";
import "./css/style.css";
import 'react-select/dist/react-select.css';
import configureStore from "./store/configureStore";
import "babel-es6-polyfill";

const store = configureStore();

render(
    <Provider store={store}>
        <div className='app'>
            <App />
        </div>
    </Provider>,
    document.querySelector('.container')
);

