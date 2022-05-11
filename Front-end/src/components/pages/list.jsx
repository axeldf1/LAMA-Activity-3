import React, {Component, useEffect, useState} from "react";
import {Link} from "react-router-dom";
import { Grid, Segment } from 'semantic-ui-react';
import {User} from '../user/containers/User';
import {UserShortDisplay} from "../user/components/UserShortDisplay";
import {useDispatch} from "react-redux";
import axios from "axios";


export const ListCards=(props)=>{
    const [currentUser, setCurrentUser] = useState({
        id: 12,
        username: "John",
        lastname: "Doe",
        login: "jDoe",
        pwd: "jdoepwd",
        money: 500,
        title: "Buy"
    });

    const [cards,setCards] = useState([]);

    const fetchAllCards = async () => {
        const { data } = await axios.get('http://localhost:8080/cards');
        const cardlist = data;
        setCards((cardlist))
        console.log(cards);
    };

    useEffect(() => {
        fetchAllCards();
    }, []);


        return (
            <div className="ui grid">
                <div>
                    <h3 className="ui aligned header"> My Card List</h3>
                    <table className="ui fixed selectable single line celled table" id="cardListId">
                        <thead>
                        <tr>
                            <th className="three wide">Name</th>
                            <th className="three wide">Description</th>
                            <th>Family</th>
                            <th>HP</th>
                            <th>Energy</th>
                            <th>Defence</th>
                            <th>Attack</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="tableContent">

                        {cards.map((card) => {
                            return(
                                <tr>
                                    <td>
                                        <img className="ui avatar image"/> <span>{card.name} </span>
                                    </td>
                                    <td>{card.description}</td>
                                    <td>{card.family}</td>
                                    <td>{card.hp}</td>
                                    <td>{card.energy}</td>
                                    <td>{card.defence}</td>
                                    <td>{card.attack}</td>
                                    <td>{card.price}$</td>
                                    <td>
                                        <div className="ui vertical animated button" tabIndex="0">
                                            <div className="hidden content">Sell</div>
                                            <div className="visible content">
                                                <i className="shop icon"></i>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            )})
                        }


                        </tbody>
                    </table>
                </div>

            </div>

        )


}

