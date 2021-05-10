import { createContext } from 'react';

const playable = {
  // 임시 데이터
  id: 1,
  away_team_status: true,
  home_team_status: false,
};

const PlayableContext = createContext();

export { playable, PlayableContext };
