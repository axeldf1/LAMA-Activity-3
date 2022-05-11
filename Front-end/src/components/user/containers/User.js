import React from 'react';
import {UserSimpleDisplay} from '../components/UserSimpleDisplay';
import {UserShortDisplay} from '../components/UserShortDisplay';
import { useSelector } from 'react-redux';

const FULL_LABEL='FULL';
const SHORT_LABEL='SHORT';

export const User=(props)=> {
    let display="";
    let current_user = useSelector(state => state.userReducer.user);
    switch(props.display_type){
        case SHORT_LABEL:
            display = (
                <UserShortDisplay
                    username = {props.username}
                    money = {props.money}>
                </UserShortDisplay>
            );

            break;
        case FULL_LABEL:
            display=(
                <UserSimpleDisplay
                    id = {props.id}
                    username = {props.username}
                    password = {props.password}>
                </UserSimpleDisplay>
            );
            break;
        default:
            display=(<h4>No Display Available</h4>);
    }
    return display;
}
