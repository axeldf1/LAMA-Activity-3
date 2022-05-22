import React, {Component, useEffect, useState} from "react";
import axios from "axios";
import {useSelector} from "react-redux";
import {ListBuyDisplay} from "../components/ListBuyDisplay";
import {ListSellDisplay} from "../components/ListSellDisplay";

const BUY_LABEL='BUY';
const SELL_LABEL='SELL';

export const User=(props)=> {
    let display="";
    let current_user = useSelector(state => state.userReducer.user);
    switch(props.display_type){
        case BUY_LABEL:
            display = (
                <ListBuyDisplay>
                </ListBuyDisplay>
            );

            break;
        case SELL_LABEL:
            display=(
                <ListSellDisplay>
                </ListSellDisplay>
            );
            break;
        default:
            display=(<h4>No Display Available</h4>);
    }
    return display;
}