export const MAIN_PATH = () => "/";
export const AUTH_PATH = () => "/auth";
export const BOARD_WRITE = () => "/board/write";
export const BOARD_LIST = () => "/board/list";
export const BOARD_DETAIL = (boardId: BigInt | string) => `/board/${boardId}`;
export const SIGN_IN_PATH = () => "/auth/sign-in";
export const SIGN_UP_PATH = () => "/auth/sign-up";

export const USER_PAGE_PATH = () => "/user-page";

export const USER_MANAGE_PATH = () => "/admin/user-list";
export const CATEGORI_MANAGE_PATH = () => "/admin/categori";
