import React, {Component, useState} from "react";
import {useSelector} from "react-redux";
export const Header=(props)=> {
    let current_user = useSelector(state => state.userReducer.user);

    return (
        <div>
            <div className="ui clearing segment">
                <h3 className="ui right floated header">
                    <i className="user circle outline icon"></i>
                    <div className="content">
                        <span id="userNameId">{current_user.name}</span>
                        <div className="sub header"><span>{current_user.balance}</span>$</div>
                    </div>
                </h3>

                <h3 className="ui left floated header">
                    <i className="money icon"></i>
                    <div className="content">
                        {props.title}
                        <div className="sub header">Sell your card to get money</div>
                    </div>
                </h3>
            </div>
        </div>

    );
}
