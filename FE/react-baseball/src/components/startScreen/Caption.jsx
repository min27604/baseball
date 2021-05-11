import styled from 'styled-components';
import { useContext } from 'react';
import { PlayableContext } from '../../App';

const Caption = (props) => {
  const { playable } = useContext(PlayableContext);
  let message = '참가할 게임을 선택하세요!';
  if (playable === false) {
    message = '이미 선택된 팀입니다. 다른 팀을 선택해주세요!';
  }
  return <Span>{message}</Span>;
};

const Span = styled.span`
  color: ${({ theme }) => theme.colors.white};
`;

export default Caption;