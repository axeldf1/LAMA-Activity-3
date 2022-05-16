import React, {Component, useState} from "react";
export const Header=(props)=> {
    const [currentUser, setCurrentUser] = useState({
        id: 12,
        username: "John",
        lastname: "Doe",
        login: "jDoe",
        pwd: "jdoepwd",
        money: 500,
        title: "Buy"
    });


    return (
        <div>
            <div className="ui clearing segment">
                <h3 className="ui right floated header">
                    <i className="user circle outline icon"></i>
                    <div className="content">
                        <span id="userNameId">{props.name}</span>
                        <div className="sub header"><span>{props.money}</span>$</div>
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
