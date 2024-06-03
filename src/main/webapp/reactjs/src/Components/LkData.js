import {GlobalFilter} from "../Components/GlobalFilter";
import {ColumnFilter} from "../Components/ColumnFilter";
import React, {useState} from "react";
import {Link} from "react-router-dom";

export const LkData = ({loginData}) => {
    const [message, setMessage] = useState('');
    const [formData, setFormData] = useState({
        firm: loginData.company,
        main_organization: loginData.companyMain,
        inn: loginData.inn,
        kpp: loginData.kpp,
        adress: loginData.adres,
        region: loginData.region,
        companyFormUR: loginData.companyForm,
        companyFormIP: loginData.companyForm,
        client_surname: loginData.surname,
        client_name: loginData.name,
        client_patronymic: loginData.othce,
        phone_number: loginData.phone,
        email: loginData.email,
    });
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };
    const handleSubmitLk = async () => {
        try {

            const lkData = {
                clientId: loginData['id'],
                ...formData
            };

            const response = await fetch('http://localhost:8080/lk', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(lkData),
            });

            if (response.ok) {
                const data = await response.json();
                setMessage('Данные успешно обновлены');
                console.log('Заказ успешно создан:', data);
            } else {
                setMessage('Ошибка при обновлении данных');
                console.error('Ошибка при создании заказа:', response.status);
            }
        } catch (error) {
            setMessage('Ошибка при обновлении данных');
            console.error('Ошибка при создании заказа:', error);
        }
    };
    return (

            <div className="w-full flex">

                    <div class="flex-grow bg-white rounded-lg p-8 shadow-lg m-10 overflow-auto">
                        <h2 className='text-2xl font-bold mb-4'>Ваши данные</h2>
                        <div class="space-y-4">
                            <div class="flex justify-between items-center">
                                <label for="client_id" class="font-bold">Номер клиента</label>
                                <input type="text" id="client_id" name="client_id" value={loginData['id']} readonly
                                       class=" rounded px-4 py-2"
                                />
                            </div>
                            <div class="flex justify-between items-center">
                                <label for="firm" class="font-bold">Наименование организации</label>
                                <input type="text" id="firm" name="firm" value={formData.firm} onChange={handleChange}
                                       class=" rounded px-4 py-2"
                                />
                            </div>
                            {loginData['companyForm'] !== 'Физлицо' && (
                                <div class="flex justify-between items-center">
                                    <label for="main_organization" class="font-bold">Основная организация</label>
                                    <input type="text" id="main_organization" name="main_organization"
                                           value={loginData['companyMain']} value={formData.main_organization} onChange={handleChange}
                                            class=" rounded px-4 py-2"/>
                                </div>
                            )}
                            <div class="flex justify-between items-center">
                                <label for="inn" class="font-bold">ИНН</label>
                                <input type="text" id="inn" name="inn" value={formData.inn} onChange={handleChange}
                                       class=" rounded px-4 py-2"/>
                            </div>
                            {loginData['companyForm'] !== 'Физлицо' && (
                                <div class="flex justify-between items-center">
                                    <label for="kpp" class="font-bold">КПП</label>
                                    <input type="text" id="kpp" name="kpp" value={formData.kpp} onChange={handleChange}
                                           class=" rounded px-4 py-2"/>
                                </div>
                            )}
                            <div class="flex justify-between items-center">
                                <label for="adress" class="font-bold">Адрес</label>
                                <input type="text" id="adress" name="adress" value={formData.adress} onChange={handleChange}
                                       class="rounded px-4 py-2"/>
                            </div>
                            {loginData['region'] !== '' && (
                                <div class="flex justify-between items-center">
                                    <label for="region" class="font-bold">Регион</label>
                                    <input type="text" id="region" name="region" value={formData.region} onChange={handleChange}
                                           class="rounded px-4 py-2"/>
                                </div>
                            )}
                            {loginData['companyForm'] !== 'Физлицо' && (
                                <div class="flex justify-between items-center">
                                    <label for="companyFormUR" class="font-bold">Юр. / Физ. лицо</label>
                                    <input type="text" id="companyFormUR" name="companyFormUR"
                                           value={loginData['companyForm']} value={formData.companyFormUR} onChange={handleChange}
                                           class=" rounded px-4 py-2"/>
                                </div>
                            )}
                            {loginData['companyForm'] !== 'Юрлицо' && (
                                <div class="flex justify-between items-center">
                                    <label for="companyFormIP" class="font-bold">Юр. / Физ. лицо</label>
                                    <input type="text" id="companyFormIP" name="companyFormIP"
                                           value={loginData['companyForm']} value={formData.companyFormIP} onChange={handleChange}
                                           class="rounded px-4 py-2"/>
                                </div>
                            )}
                            <div class="flex justify-between items-center">
                                <label for="client_surname" class="font-bold">Фамилия</label>
                                <input type="text" id="client_surname" name="client_surname"
                                       value={loginData['surname']} value={formData.client_surname} onChange={handleChange}
                                       class="rounded px-4 py-2 "/>
                            </div>
                            <div class="flex justify-between items-center">
                                <label for="client_name" class="font-bold">Имя</label>
                                <input type="text" id="client_name" name="client_name" value={formData.client_name} onChange={handleChange}
                                       class="rounded px-4 py-2 "/>
                            </div>
                            {loginData['othce'] != null && (
                                <div class="flex justify-between items-center">
                                    <label for="client_patronymic" class="font-bold">Отчество</label>
                                    <input type="text" id="client_patronymic" name="client_patronymic" value={formData.client_patronymic} onChange={handleChange}
                                           value={loginData['othce']}
                                           class=" rounded px-4 py-2"/>
                                </div>
                            )}
                            <div class="flex justify-between items-center">
                                <label for="phone_number" class="font-bold">Номер телефона</label>
                                <input type="text" id="phone_number" name="phone_number" value={loginData['phone']} value={formData.phone_number} onChange={handleChange}
                                       class=" rounded px-4 py-2"/>
                            </div>
                            <div class="flex justify-between items-center">
                                <label for="email" class="font-bold">E-mail</label>
                                <input type="email" id="email" name="email" value={loginData['email']} value={formData.email} onChange={handleChange}
                                       class=" rounded px-4 py-2 "/>
                            </div>

                            {message && <p className="text-green-500 mb-4">{message}</p>}
                            <button
                                className="bg-yellow-500 w-full text-gray-800 font-bold py-2 px-8 rounded-lg text-xl my-5" onClick={handleSubmitLk}
                            >
                                Сохранить изменения
                            </button>

                        </div>
                    </div>


            </div>
    )
}