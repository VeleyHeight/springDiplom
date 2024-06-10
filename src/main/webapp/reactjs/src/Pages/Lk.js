import {GlobalFilter} from "../Components/GlobalFilter";
import {ColumnFilter} from "../Components/ColumnFilter";
import React from "react";
import {Link} from "react-router-dom";
import {LkData} from "../Components/LkData";

export const Lk = ({loginData, setLoginData}) => {
    const handleLogout = () => {
        setLoginData(null);
    }

    return (<div className="flex flex-row min-h-screen py-8  bg-gray-300">
            <div
                className="flex-shrink-0 bg-white rounded-lg p-8 shadow-lg w-60 py-2 self-start bg-white rounded-lg mx-5 mt-10">
                <h2 className="text-xl py-2 text-gray-800 font-bold">Функции</h2>
                <button className="bg-yellow-500 w-full text-gray-800 font-bold py-2 px-8 rounded-lg text-xl my-2"
                >
                    Данные аккаунта
                </button>

                <Link to={"/login"}>
                    <button className="bg-yellow-500 w-full text-gray-800 font-bold py-2 px-8 rounded-lg text-xl my-2"
                            onClick={handleLogout}
                    >
                        Выйти
                    </button>

                </Link>

            </div>
            <LkData loginData={loginData}/>
        </div>
    )
}