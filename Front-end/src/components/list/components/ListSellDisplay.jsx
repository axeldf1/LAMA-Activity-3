import React, {Component, useEffect, useState} from "react";
import axios from "axios";
import {useSelector} from "react-redux";


export const ListSellDisplay=(props)=>{
    let current_user = useSelector(state => state.userReducer.user);


    const [cards,setCards] = useState([]);

    const fetchAllCards = async () => {
        const { data } = await axios.get('http://localhost:8080/market');
        const cardlist = data;
        setCards(cardlist)
        console.log(cards);
    };

    const fetchSell1Card = async (id) => {
        const { data } = await axios.post('http://localhost:8080/buy/'+id);
        const cardlist = data;
        setCards(cardlist)
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
                                        <div id="" className="hidden content" onClick={fetchSell1Card()}>{props.action}</div>
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
