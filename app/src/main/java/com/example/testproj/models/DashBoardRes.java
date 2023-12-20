package com.example.testproj.models;

public class DashBoardRes {

    public String statusText;
    public int statusCode;
    public String statusType;
    public Data data;

    public DashBoardRes() {
    }

    public DashBoardRes(String statusText, int statusCode, String statusType, Data data) {
        this.statusText = statusText;
        this.statusCode = statusCode;
        this.statusType = statusType;
        this.data = data;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        public String FullName;
        public String JoiningDate;
        public String MobileNo;
        public String EmailId;
        public int TotalLeftTeam;
        public int TotalRightTeam;
        public int TotalLeftActiveTeam;
        public int TotalRightActiveTeam;
        public int TotalTeam;
        public int TotalActiveTeam;
        public int TotalInactiveTeam;
        public int TotalDirects;
        public int TotalActiveDirects;
        public int TotalInactiveDirects;
        public double DirectInvestment;
        public double TeamBusinessLH;
        public double TeamBusinessRH;
        public double TeamBusinessLM;
        public double TeamBusinessRM;
        public double MatchingIncome;
        public double MatchingLevelIncome;
        public double DirectIncome;
        public double SpillIncome;
        public double ROIIncome;
        public double ArbitrageROIIncome;
        public double LevelROIIncome;
        public double LevelIncome;
        public double LevelROIBinbaryIncome;
        public double TotalBonus;
        public double TotalIncome;
        public double TotalIncome_Daily;
        public double TotalIncome_Weekly;
        public String Package;
        public double PackageValue;
        public double MintingPackageValue;
        public String ActivationDate;
        public double WalletBalance;
        public double DepositWalletBalance;
        public int ROITimeRemaining_Minutes;
        public double DMB_MatchingIncome;
        public double RankIncome;
        public double SuperStarRoyaltyIncome;
        public double DMB_Value;
        public String CurrentRank;
        public int HasTopupWithMinting;
        public double ArbitrageWalletBalance;
        public double Capacity;

        public Data() {
        }

        public Data(String fullName, String joiningDate, String mobileNo, String emailId, int totalLeftTeam, int totalRightTeam, int totalLeftActiveTeam, int totalRightActiveTeam, int totalTeam, int totalActiveTeam, int totalInactiveTeam, int totalDirects, int totalActiveDirects, int totalInactiveDirects, double directInvestment, double teamBusinessLH, double teamBusinessRH, double teamBusinessLM, double teamBusinessRM, double matchingIncome, double matchingLevelIncome, double directIncome, double spillIncome, double ROIIncome, double arbitrageROIIncome, double levelROIIncome, double levelIncome, double levelROIBinbaryIncome, double totalBonus, double totalIncome, double totalIncome_Daily, double totalIncome_Weekly, String aPackage, double packageValue, double mintingPackageValue, String activationDate, double walletBalance, double depositWalletBalance, int ROITimeRemaining_Minutes, double DMB_MatchingIncome, double rankIncome, double superStarRoyaltyIncome, double DMB_Value, String currentRank, int hasTopupWithMinting, double arbitrageWalletBalance, double capacity) {
            FullName = fullName;
            JoiningDate = joiningDate;
            MobileNo = mobileNo;
            EmailId = emailId;
            TotalLeftTeam = totalLeftTeam;
            TotalRightTeam = totalRightTeam;
            TotalLeftActiveTeam = totalLeftActiveTeam;
            TotalRightActiveTeam = totalRightActiveTeam;
            TotalTeam = totalTeam;
            TotalActiveTeam = totalActiveTeam;
            TotalInactiveTeam = totalInactiveTeam;
            TotalDirects = totalDirects;
            TotalActiveDirects = totalActiveDirects;
            TotalInactiveDirects = totalInactiveDirects;
            DirectInvestment = directInvestment;
            TeamBusinessLH = teamBusinessLH;
            TeamBusinessRH = teamBusinessRH;
            TeamBusinessLM = teamBusinessLM;
            TeamBusinessRM = teamBusinessRM;
            MatchingIncome = matchingIncome;
            MatchingLevelIncome = matchingLevelIncome;
            DirectIncome = directIncome;
            SpillIncome = spillIncome;
            this.ROIIncome = ROIIncome;
            ArbitrageROIIncome = arbitrageROIIncome;
            LevelROIIncome = levelROIIncome;
            LevelIncome = levelIncome;
            LevelROIBinbaryIncome = levelROIBinbaryIncome;
            TotalBonus = totalBonus;
            TotalIncome = totalIncome;
            TotalIncome_Daily = totalIncome_Daily;
            TotalIncome_Weekly = totalIncome_Weekly;
            Package = aPackage;
            PackageValue = packageValue;
            MintingPackageValue = mintingPackageValue;
            ActivationDate = activationDate;
            WalletBalance = walletBalance;
            DepositWalletBalance = depositWalletBalance;
            this.ROITimeRemaining_Minutes = ROITimeRemaining_Minutes;
            this.DMB_MatchingIncome = DMB_MatchingIncome;
            RankIncome = rankIncome;
            SuperStarRoyaltyIncome = superStarRoyaltyIncome;
            this.DMB_Value = DMB_Value;
            CurrentRank = currentRank;
            HasTopupWithMinting = hasTopupWithMinting;
            ArbitrageWalletBalance = arbitrageWalletBalance;
            Capacity = capacity;
        }

        public String getFullName() {
            return FullName;
        }

        public void setFullName(String fullName) {
            FullName = fullName;
        }

        public String getJoiningDate() {
            return JoiningDate;
        }

        public void setJoiningDate(String joiningDate) {
            JoiningDate = joiningDate;
        }

        public String getMobileNo() {
            return MobileNo;
        }

        public void setMobileNo(String mobileNo) {
            MobileNo = mobileNo;
        }

        public String getEmailId() {
            return EmailId;
        }

        public void setEmailId(String emailId) {
            EmailId = emailId;
        }

        public int getTotalLeftTeam() {
            return TotalLeftTeam;
        }

        public void setTotalLeftTeam(int totalLeftTeam) {
            TotalLeftTeam = totalLeftTeam;
        }

        public int getTotalRightTeam() {
            return TotalRightTeam;
        }

        public void setTotalRightTeam(int totalRightTeam) {
            TotalRightTeam = totalRightTeam;
        }

        public int getTotalLeftActiveTeam() {
            return TotalLeftActiveTeam;
        }

        public void setTotalLeftActiveTeam(int totalLeftActiveTeam) {
            TotalLeftActiveTeam = totalLeftActiveTeam;
        }

        public int getTotalRightActiveTeam() {
            return TotalRightActiveTeam;
        }

        public void setTotalRightActiveTeam(int totalRightActiveTeam) {
            TotalRightActiveTeam = totalRightActiveTeam;
        }

        public int getTotalTeam() {
            return TotalTeam;
        }

        public void setTotalTeam(int totalTeam) {
            TotalTeam = totalTeam;
        }

        public int getTotalActiveTeam() {
            return TotalActiveTeam;
        }

        public void setTotalActiveTeam(int totalActiveTeam) {
            TotalActiveTeam = totalActiveTeam;
        }

        public int getTotalInactiveTeam() {
            return TotalInactiveTeam;
        }

        public void setTotalInactiveTeam(int totalInactiveTeam) {
            TotalInactiveTeam = totalInactiveTeam;
        }

        public int getTotalDirects() {
            return TotalDirects;
        }

        public void setTotalDirects(int totalDirects) {
            TotalDirects = totalDirects;
        }

        public int getTotalActiveDirects() {
            return TotalActiveDirects;
        }

        public void setTotalActiveDirects(int totalActiveDirects) {
            TotalActiveDirects = totalActiveDirects;
        }

        public int getTotalInactiveDirects() {
            return TotalInactiveDirects;
        }

        public void setTotalInactiveDirects(int totalInactiveDirects) {
            TotalInactiveDirects = totalInactiveDirects;
        }

        public double getDirectInvestment() {
            return DirectInvestment;
        }

        public void setDirectInvestment(double directInvestment) {
            DirectInvestment = directInvestment;
        }

        public double getTeamBusinessLH() {
            return TeamBusinessLH;
        }

        public void setTeamBusinessLH(double teamBusinessLH) {
            TeamBusinessLH = teamBusinessLH;
        }

        public double getTeamBusinessRH() {
            return TeamBusinessRH;
        }

        public void setTeamBusinessRH(double teamBusinessRH) {
            TeamBusinessRH = teamBusinessRH;
        }

        public double getTeamBusinessLM() {
            return TeamBusinessLM;
        }

        public void setTeamBusinessLM(double teamBusinessLM) {
            TeamBusinessLM = teamBusinessLM;
        }

        public double getTeamBusinessRM() {
            return TeamBusinessRM;
        }

        public void setTeamBusinessRM(double teamBusinessRM) {
            TeamBusinessRM = teamBusinessRM;
        }

        public double getMatchingIncome() {
            return MatchingIncome;
        }

        public void setMatchingIncome(double matchingIncome) {
            MatchingIncome = matchingIncome;
        }

        public double getMatchingLevelIncome() {
            return MatchingLevelIncome;
        }

        public void setMatchingLevelIncome(double matchingLevelIncome) {
            MatchingLevelIncome = matchingLevelIncome;
        }

        public double getDirectIncome() {
            return DirectIncome;
        }

        public void setDirectIncome(double directIncome) {
            DirectIncome = directIncome;
        }

        public double getSpillIncome() {
            return SpillIncome;
        }

        public void setSpillIncome(double spillIncome) {
            SpillIncome = spillIncome;
        }

        public double getROIIncome() {
            return ROIIncome;
        }

        public void setROIIncome(double ROIIncome) {
            this.ROIIncome = ROIIncome;
        }

        public double getArbitrageROIIncome() {
            return ArbitrageROIIncome;
        }

        public void setArbitrageROIIncome(double arbitrageROIIncome) {
            ArbitrageROIIncome = arbitrageROIIncome;
        }

        public double getLevelROIIncome() {
            return LevelROIIncome;
        }

        public void setLevelROIIncome(double levelROIIncome) {
            LevelROIIncome = levelROIIncome;
        }

        public double getLevelIncome() {
            return LevelIncome;
        }

        public void setLevelIncome(double levelIncome) {
            LevelIncome = levelIncome;
        }

        public double getLevelROIBinbaryIncome() {
            return LevelROIBinbaryIncome;
        }

        public void setLevelROIBinbaryIncome(double levelROIBinbaryIncome) {
            LevelROIBinbaryIncome = levelROIBinbaryIncome;
        }

        public double getTotalBonus() {
            return TotalBonus;
        }

        public void setTotalBonus(double totalBonus) {
            TotalBonus = totalBonus;
        }

        public double getTotalIncome() {
            return TotalIncome;
        }

        public void setTotalIncome(double totalIncome) {
            TotalIncome = totalIncome;
        }

        public double getTotalIncome_Daily() {
            return TotalIncome_Daily;
        }

        public void setTotalIncome_Daily(double totalIncome_Daily) {
            TotalIncome_Daily = totalIncome_Daily;
        }

        public double getTotalIncome_Weekly() {
            return TotalIncome_Weekly;
        }

        public void setTotalIncome_Weekly(double totalIncome_Weekly) {
            TotalIncome_Weekly = totalIncome_Weekly;
        }

        public String getPackage() {
            return Package;
        }

        public void setPackage(String aPackage) {
            Package = aPackage;
        }

        public double getPackageValue() {
            return PackageValue;
        }

        public void setPackageValue(double packageValue) {
            PackageValue = packageValue;
        }

        public double getMintingPackageValue() {
            return MintingPackageValue;
        }

        public void setMintingPackageValue(double mintingPackageValue) {
            MintingPackageValue = mintingPackageValue;
        }

        public String getActivationDate() {
            return ActivationDate;
        }

        public void setActivationDate(String activationDate) {
            ActivationDate = activationDate;
        }

        public double getWalletBalance() {
            return WalletBalance;
        }

        public void setWalletBalance(double walletBalance) {
            WalletBalance = walletBalance;
        }

        public double getDepositWalletBalance() {
            return DepositWalletBalance;
        }

        public void setDepositWalletBalance(double depositWalletBalance) {
            DepositWalletBalance = depositWalletBalance;
        }

        public int getROITimeRemaining_Minutes() {
            return ROITimeRemaining_Minutes;
        }

        public void setROITimeRemaining_Minutes(int ROITimeRemaining_Minutes) {
            this.ROITimeRemaining_Minutes = ROITimeRemaining_Minutes;
        }

        public double getDMB_MatchingIncome() {
            return DMB_MatchingIncome;
        }

        public void setDMB_MatchingIncome(double DMB_MatchingIncome) {
            this.DMB_MatchingIncome = DMB_MatchingIncome;
        }

        public double getRankIncome() {
            return RankIncome;
        }

        public void setRankIncome(double rankIncome) {
            RankIncome = rankIncome;
        }

        public double getSuperStarRoyaltyIncome() {
            return SuperStarRoyaltyIncome;
        }

        public void setSuperStarRoyaltyIncome(double superStarRoyaltyIncome) {
            SuperStarRoyaltyIncome = superStarRoyaltyIncome;
        }

        public double getDMB_Value() {
            return DMB_Value;
        }

        public void setDMB_Value(double DMB_Value) {
            this.DMB_Value = DMB_Value;
        }

        public String getCurrentRank() {
            return CurrentRank;
        }

        public void setCurrentRank(String currentRank) {
            CurrentRank = currentRank;
        }

        public int getHasTopupWithMinting() {
            return HasTopupWithMinting;
        }

        public void setHasTopupWithMinting(int hasTopupWithMinting) {
            HasTopupWithMinting = hasTopupWithMinting;
        }

        public double getArbitrageWalletBalance() {
            return ArbitrageWalletBalance;
        }

        public void setArbitrageWalletBalance(double arbitrageWalletBalance) {
            ArbitrageWalletBalance = arbitrageWalletBalance;
        }

        public double getCapacity() {
            return Capacity;
        }

        public void setCapacity(double capacity) {
            Capacity = capacity;
        }
    }
}
