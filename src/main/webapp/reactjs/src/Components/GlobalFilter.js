import React,{useState} from 'react'
import { useAsyncDebounce } from 'react-table';


export const GlobalFilter = ({ filter, setFilter}) => {
  const [value, setValue] = useState(filter)
  const onChange = useAsyncDebounce(value => {
    setFilter(value || undefined)
  }, 300)
    return (
      <div>
        <input
          value={value || ''}
          onChange={(e) =>
             {setValue(e.target.value)
            onChange(e.target.value)
          }}
          placeholder="Глобальный поиск"
          className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
        />
       
      </div>
    );
  };