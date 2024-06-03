import React,{useState} from 'react'
import { useAsyncDebounce } from 'react-table';

export const ColumnFilter = ({ column }) => {
  const { filterValue, setFilter } = column;
  const [value, setValue] = useState(filterValue);
  const onChange = useAsyncDebounce(value => {
    setFilter(value || undefined);
  }, 300);

  return (
    <span>
      <input
        value={value || ''}
        onChange={e => {
          setValue(e.target.value);
          onChange(e.target.value);
        }}
        placeholder="Поиск типоразмера"
        className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
      />
    </span>
  );
};