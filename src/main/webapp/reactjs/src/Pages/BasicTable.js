import React, { useState, useEffect, useMemo } from 'react'
import { useTable, useSortBy, useGlobalFilter, useFilters, usePagination, useRowSelect } from 'react-table'
import MOCK_DATA from '../Components/MOCK_DATA.json'
import { COLUMNS } from '../Components/columns'
import SortAZ from '../SVG/SortAZ';
import SortZA from '../SVG/SortZA';
import { GlobalFilter } from '../Components/GlobalFilter';
import { ColumnFilter } from '../Components/ColumnFilter';
import PushLeft from '../SVG/PushLeft';
import PushRight from '../SVG/PushRight';
import FirstPage from '../SVG/FirstPage';
import LastPage from '../SVG/LastPage';
import { Checkbox } from '../Components/CheckBox';
import Header from '../Components/Header';
export const BasicTable = ({ setBasketData, basketData }) => {
  const columns = useMemo(() => COLUMNS, []);
  const [rowClickCounts, setRowClickCounts] = useState({});
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/data', );
        const jsonData = await response.json();
        setData(jsonData);
      } catch (error) {
        console.error('Ошибка при получении данных:', error);
      }
    };

    fetchData();
  }, []);
  // const data = useMemo(() => MOCK_DATA, []);

  const { getTableProps, getTableBodyProps, headerGroups, page, nextPage, previousPage, canPreviousPage, canNextPage,
    pageOptions, prepareRow, state, setGlobalFilter, gotoPage, pageCount, setPageSize, selectedFlatRows } = useTable({
      columns,
      data,
      initialState: { pageSize: 50 },
    },
      useFilters,
      useGlobalFilter,
      useSortBy,
      usePagination,
      useRowSelect,
      hooks => {
        hooks.visibleColumns.push(columns => [
          ...columns,
          {
            id: 'selection',
            Header: () => null,
            Cell: ({ row }) => (
              <Checkbox
                {...row.getToggleRowSelectedProps()}
                rowData={row.original}
                rowClickCounts={rowClickCounts}
                setRowClickCounts={setRowClickCounts}
                onClick={() => {
                  row.toggleRowSelected(true);
                }}
                setBasketData={setBasketData}
                basketData={basketData}
              />
            )
          }
        ])
      }
    );


  const { globalFilter, pageIndex, pageSize } = state
  const handlePageChange = () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth',
    });
  };

  return (

    <div className="flex flex-row min-h-screen py-8  bg-gray-300">
      <div className="flex-shrink-0 bg-white rounded-lg p-8 shadow-lg w-60 py-2 self-start bg-white rounded-lg mx-5">
        <h2 className="text-xl py-2 text-gray-800 font-bold">Фильтр</h2>
        <GlobalFilter filter={globalFilter} setFilter={setGlobalFilter} />
        <ColumnFilter column={headerGroups[0].headers[4]} />
      </div>
      <div className="flex-grow bg-white rounded-lg p-8 shadow-lg w-60">
        <div className="justify-center bg-white rounded-lg w-full p-2 h-full max-h-full">

          <table
            {...getTableProps}
            className="table-auto w-full border-collapse rounded-lg overflow-hidden m-0 max-w-full"
          >
            <thead className="text-black w-full max-w-full m-0">
              {headerGroups.map((headerGroup, index) => (
                <tr key={index} {...headerGroup.getHeaderGroupProps()}>
                  {headerGroup.headers.map((column, index) => (
                    <th
                      key={index}
                      {...column.getHeaderProps(column.getSortByToggleProps())}
                      className={`justify-between px-4 py-2 font-bold bg-yellow-500 text-left ${index === 0 ? 'rounded-l-lg' : ''
                        } ${index === headerGroup.headers.length - 1 ? 'rounded-r-lg' : ''}`}
                    >
                      {column.render('Header')}
                      {/* <div>{column.canFilter?column.render('Filter'):null}</div> */}
                      {column.isSorted ? column.isSortedDesc ? <SortAZ /> : <SortZA /> : ''}
                    </th>
                  ))}
                </tr>
              ))}
            </thead>
            <tbody {...getTableBodyProps} className="text-gray-800 ">
              {page.map((row, index) => {
                prepareRow(row);
                return (
                  <tr
                    key={index}
                    {...row.getRowProps()}
                    className={`${index % 2 === 1 ? 'bg-gray-200' : 'bg-white'
                      }`}
                  >
                    {row.cells.map((cell, index) => {
                      return (
                        <td
                          key={index}
                          {...cell.getCellProps()}
                          className={`px-4 py-2 text-left   ${index === 0 ? 'rounded-l-lg' : ''
                            } ${index === row.cells.length - 1 ? 'rounded-r-lg' : ''}`}
                        >
                          {cell.render('Cell')}
                        </td>
                      );
                    })}
                  </tr>
                );
              })}
            </tbody>

          </table>
          {page.length === 0 ? (
            <div className="text-center text-gray-800 font-bold py-8">
              Нет товаров соответствующих вашему фильтру
            </div>
          ) : (
            <div className=" bottom-0 bg-white p-2 flex flex-col gap-4 max-h-full h-fill">
              <div className='flex justify-between items-center py-2'>
                <select className='w-[200px] border-black border font-bold rounded-lg text-sm rounded-lg block p-1.5 text-color-black'
                  value={pageSize}
                  onChange={e => setPageSize(Number(e.target.value))}>
                  {[50, 100, 200].map(pageSize => (
                    <option key={pageSize} value={pageSize}>
                      {pageSize}
                    </option>
                  ))}
                </select>
                <div className='flex justify-center gap-2 flex-grow' >
                  {/* Кнопки */}
                  <button onClick={() => { gotoPage(0); handlePageChange(); }} ><FirstPage /></button>
                  <button onClick={() => { previousPage(); handlePageChange(); }} ><PushLeft /></button>

                  <strong>
                    {pageOptions.length === 0 ? 0 : pageIndex + 1} из {pageOptions.length}
                  </strong>
                  <button onClick={() => { nextPage(); handlePageChange(); }} ><PushRight /></button>
                  <button onClick={() => { gotoPage(pageCount - 1); handlePageChange(); }} ><LastPage /></button>
                </div>
                <input
                  className=' w-[200px] font-bold border-solid border border-black rounded-lg block p-1.5 placeholder-black'
                  type='number'
                  placeholder='Поиск страницы'
                  onChange={e => {
                    const pageNumber = e.target.value ? Number(e.target.value) - 1 : ''
                    gotoPage(pageNumber)
                  }} />
              </div>
            </div>
          )}
        </div>
      </div>
      <div className="flex-shrink-0 w-60 bg-gray-300 p-8 mx-5"></div>
    </div>
  );
};
