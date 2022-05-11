import React, {Component, useState} from "react";
import {Link} from "react-router-dom";
import { Grid, Segment } from 'semantic-ui-react';
import {User} from '../user/containers/User';
import {UserShortDisplay} from "../user/components/UserShortDisplay";

export const Header=(props)=> {
    const [header, setCurrentUser] = useState({
    });


    return (
        <div>
            <div className="ui clearing segment">
                <h3 className="ui right floated header">
                    <i className="user circle outline icon"></i>
                    <div className="content">
                        <span id="userNameId">Jdoe</span>
                        <div className="sub header"><span>5000</span>$</div>
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
