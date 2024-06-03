import React, { useState } from 'react';
import { Link } from 'react-router-dom';

export const Checkbox = React.forwardRef(({ onClick, isSelected, rowData, rowClickCounts, setRowClickCounts, setBasketData, basketData, ...rest }, ref) => {
  const [quantity, setQuantity] = useState(1);
  const [inBasket, setInBasket] = useState(false);

  const handleClick = (event) => {
    setRowClickCounts(prevCounts => {
      const newCounts = { ...prevCounts };
      newCounts[rowData] = (newCounts[rowData] || 0) + quantity;
      return newCounts;
    });
    setInBasket(true);
    const [id, name, category, supplier, brand, size, price] = rowData;

    const existingItem = basketData.find((item) => item.id === id);
        if (existingItem) {
          setBasketData((prevData) =>
            prevData.map((item) =>
              item.id === id
                ? {
                    ...item,
                    clickCount: item.clickCount + quantity,
                  }
                : item
            )
          );
        } else {
          setBasketData((prevData) => [
            ...prevData,
            {
              id,
              name,
              price,
              clickCount: (rowClickCounts[rowData] || 0) + quantity,
            },
          ]);
        }
    onClick(event);
  };

  const clickCount = rowClickCounts[rowData] || 0;

  const decrementQuantity = () => {
    if (quantity > 1) {
      setQuantity(quantity - 1);
    }
  };

  const incrementQuantity = () => {
    setQuantity(quantity + 1);
  };

  return (
    <>
      {inBasket ? (
        <Link
          to="/basket"
          className="bg-yellow-500 text-gray-800 font-bold py-2 px-4 rounded block transition-all duration-300 flex items-center justify-center h-20">
          В корзину
        </Link>
      ) : (
        <span className="max-w-44">
          <button
            ref={ref}
            onClick={handleClick}
            {...rest}
            className="bg-gray-800 text-white font-bold py-2 px-4 rounded">
            Добавить в корзину
          </button>
          <div className="flex items-center mt-2 max-w-44">
            <button
              onClick={decrementQuantity}
              className="bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold py-1 px-2 rounded">
              -
            </button>
            <input
              type="number"
              value={quantity}
              min="1"
              onChange={(e) => {if(e.target.value >=1){setQuantity(parseInt(e.target.value))}
            else{
              setQuantity(1)
            }}}
              className="mx-2 py-1 px-2 rounded-md border border-gray-300 text-center max-w-28"
            />
            <button
              onClick={incrementQuantity}
              className="bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold py-1 px-2 rounded">
              +
            </button>
          </div>
        </span>
      )}
    </>
  );
});